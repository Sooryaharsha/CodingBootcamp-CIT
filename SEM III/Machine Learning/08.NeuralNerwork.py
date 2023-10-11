import numpy as np


class NeuralNetwork:
    def __init__(self, input_size, hidden_size, output_size, learning_rate=0.1):
        # Initialize weights and biases
        self.weights = np.random.randn(input_size, hidden_size)
        self.biases = np.random.randn(hidden_size)
        self.output_weights = np.random.randn(hidden_size, output_size)
        self.output_biases = np.random.randn(output_size)
        self.learning_rate = learning_rate

    def forward(self, X):
        # Calculate the output of the hidden layer
        hidden_layer = np.dot(X, self.weights) + self.biases
        # Apply the activation function
        hidden_layer = np.tanh(hidden_layer)
        # Calculate the output of the output layer
        output_layer = np.dot(hidden_layer, self.output_weights) + self.output_biases
        # Apply the activation function
        output_layer = np.tanh(output_layer)
        return hidden_layer, output_layer

    def backward(self, X, y, hidden_layer, output_layer):
        # Calculate the error for the output layer
        output_error = y - output_layer
        # Calculate the delta for the output layer
        output_delta = output_error * (1 - output_layer**2)
        # Calculate the error for the hidden layer
        hidden_error = np.dot(output_delta, self.output_weights.T) * (
            1 - hidden_layer**2
        )

        # Update the weights and biases for the output layer
        self.output_weights += self.learning_rate * np.dot(hidden_layer.T, output_delta)
        self.output_biases += self.learning_rate * output_delta.sum(axis=0)

        # Update the weights and biases for the hidden layer
        self.weights += self.learning_rate * np.dot(X.T, hidden_error)
        self.biases += self.learning_rate * hidden_error.sum(axis=0)

    def train(self, X, y, epochs=100):
        for epoch in range(epochs):
            hidden_layer, output_layer = self.forward(X)
            self.backward(X, y, hidden_layer, output_layer)

    def predict(self, X):
        hidden_layer, output_layer = self.forward(X)
        return output_layer


# Test the neural network on the MNIST dataset
from sklearn.datasets import fetch_openml

mnist = fetch_openml("mnist_784")
X = mnist["data"].astype(np.float32)
y = mnist["target"].astype(np.int32)

# Split the data into training and test sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25)

# Create a neural network with one hidden layer
neural_network = NeuralNetwork(input_size=784, hidden_size=128, output_size=10)

# Train the neural network
neural_network.train(X_train, y_train, epochs=10)

# Evaluate the neural network on the test set
y_pred = neural_network.predict(X_test)
accuracy = (y_pred == y_test).sum() / len(y_test)
print(f"Accuracy on test set: {accuracy * 100:.2f}%")
