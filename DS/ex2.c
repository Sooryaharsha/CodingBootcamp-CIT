// Binary Search Tree operations in C

#include <stdio.h>
#include <stdlib.h>

struct node {
  int key;
  struct node *left, *right;
};

// Create a node
struct node *newNode(int item) {
  struct node *temp = (struct node *)malloc(sizeof(struct node));
  temp->key = item;
  temp->left = temp->right = NULL;
  return temp;
}


void inorder(struct node *root) {
  if (root != NULL) {
   
    inorder(root->left);

    
    printf("%d -> ", root->key);

    
    inorder(root->right);
  }
}

void printLeafNodes(struct node *root)
{
	if (!root)
		return;
	
	if (!root->left && !root->right)
	{
		printf("%d-->",root->key);
		return;
	}

	if (root->left)
	printLeafNodes(root->left);
		
	if (root->right)
	printLeafNodes(root->right);
}

struct node *insert(struct node *node, int key) {
  
  if (node == NULL) return newNode(key);


  if (key < node->key)
    node->left = insert(node->left, key);
  else
    node->right = insert(node->right, key);

  return node;
}



int main() {
  struct node *root = NULL;
  root = insert(root, 20);
  root = insert(root, 25);
  root = insert(root, 13);
  root = insert(root, 16);
  root = insert(root, 14);
  root = insert(root, 26);
  root = insert(root, 31);
  root = insert(root, 42);
  root = insert(root, 18);
  root = insert(root, 17);
  

  printf("Inorder traversal: ");
  inorder(root);
  printf("\n\nThe leaf nodes are : ");
  printLeafNodes(root);
  

 
}
