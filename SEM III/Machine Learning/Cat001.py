import numpy as np


class Node:
    def __init__(self, attribute, value, children):
        self.attribute = attribute
        self.value = value
        self.children = children
        self.isLeaf = False

    def predict(self, features):
        if self.isLeaf:
            return self.value
        else:
            return self.children[features[self.attribute]]


def entropy(labels):
    unique_labels = np.unique(labels)
    probabilities = np.array(
        [np.sum(labels == label) / len(labels) for label in unique_labels]
    )
    entropy = -np.sum(probabilities * np.log2(probabilities))
    return entropy


def information_gain(parent_entropy, features, labels):
    gain = parent_entropy
    for attribute in features:
        unique_values = np.unique(features[attribute])
        for value in unique_values:
            subset = labels[features[attribute] == value]
            entropy_subset = entropy(subset)
            gain -= entropy_subset * np.sum(features[attribute] == value) / len(labels)
    return gain


def id3(features, labels, attributes):
    root = Node(None, None, {})

    if len(set(labels)) == 1:
        root.isLeaf = True
        root.value = labels[0]
        return root

    best_attribute = None
    best_gain = 0

    for attribute in attributes:
        gain = information_gain(entropy(labels), features[attribute], labels)
        if gain > best_gain:
            best_attribute = attribute
            best_gain = gain

    if best_attribute is None:
        root.isLeaf = True
        root.value = np.argmax(np.bincount(labels))
        return root

    root.attribute = best_attribute

    for value in np.unique(features[best_attribute]):
        subset_features = features[features[best_attribute] == value]
        subset_labels = labels[features[best_attribute] == value]
        subset_attributes = attributes[:]
        subset_attributes.remove(best_attribute)

        child = id3(subset_features, subset_labels, subset_attributes)
        root.children[value] = child

    return root


# Example usage:

features = np.array(
    [
        [12, 100, 1],
        [24, 50, 2],
        [6, 200, 3],
        [18, 80, 1],
        [12, 150, 2],
        [24, 60, 1],
        [6, 250, 3],
        [18, 70, 2],
        [12, 130, 1],
        [24, 40, 3],
    ]
)
labels = np.array(["No", "No", "Yes", "No",
                   "Yes", "No", "Yes", "No", "No", "Yes"])
attributes = ["Contract Length", "Monthly Usage", "Support Calls", "Churn"]

tree = id3(features, labels, attributes)

# Print the tree


def print_tree(node, indent=0):
    if node.isLeaf:
        print("{}{}: {}".format(indent * " ", node.attribute, node.value))
    else:
        print("{}{}: {}".format(indent * " ", node.attribute, node.value))
        for child in node.children:
            print_tree(node.children[child], indent + 1)


print_tree(tree)
