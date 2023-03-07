#include<stdio.h>
#include<stdlib.h>
#include<string.h>
struct node
{
    char data[10];
    struct node *left;
    struct node *right;
};
struct node *root=0;
struct node* getnewnode(char name[])
{
    struct node* newnode;
    newnode=(struct node*)malloc(sizeof(struct node));
    strcpy(newnode->data,name);
    newnode->left=0;
    newnode->right=0;
    return newnode;
}
struct node* insert(struct node *root,char name[])
{
    if(root==0)
    {
        root=getnewnode(name);
        return root;
    }
    else if(strcmp(name,root->data)<0)
    {
        root->left=insert(root->left,name);
    }
    else
    {
        root->right=insert(root->right,name);
    }
    return root;
}
int search(struct node* root,char name[])
{
    if(root==0) return 0;
    else if(strcmp(root->data,name)==0) return 1;
    else if(strcmp(name,root->data)<0) return search(root->left,name);
    else return search(root->right,name);
}
void main()
{
    struct node *root=0;
    char name[10];
    int choice;
    do
    {
        printf("Enter name: ");
        scanf("%s",&name);
        root=insert(root,name);
        printf("Enter choice(0 to exit): ");
        scanf("%d",&choice);
    }while(choice!=0);

    printf("Enter name to be search: ");
    scanf("%s",&name);
    if(search(root,name)==1)
    {
        printf("\n\t\t!!!Name found!!!");
    }
    else
    {
        printf("\nName not found");
    }

}


