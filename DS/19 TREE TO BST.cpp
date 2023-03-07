#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *left,*right;
};
int temp[100],i=0;
struct node* create()
{
    int x;
    struct node *newnode;
    newnode=(struct node*)malloc(sizeof(struct node));
    printf("Enter value(-1 to exit): ");
    scanf("%d",&x);
    if(x==-1)
    {
        return 0;
    }
    newnode->data=x;
    printf("Enter left child of %d ",x);
    newnode->left=create();
    printf("Enter right child of %d ",x);
    newnode->right=create();
    return newnode;
}

void inorder(struct node *root)
{
    if(root==0) return;
    inorder(root->left);
    printf("%d ",root->data);
    temp[i]=root->data;
    i++;
    inorder(root->right);
}

int cmpfunc(const void *a,const void *b)
{
    return (*(int*)a-*(int*)b);
}
void reinorder(struct node *root,int *pos)
{
    if(root==0) return;
    reinorder(root->left,pos);
    root->data=temp[*pos];
    (*pos)++;
    reinorder(root->right,pos);
}
int main()
{
    struct node *root=0;
    root=create();
    printf("Inoder traversal of entered tree: ");
    inorder(root);
    printf("\nInorder traversal  stored in array: ");
    for(int x=0;x<i;x++)
    {
        printf("%d ",temp[x]);
    }
    qsort(temp,i,sizeof(int),cmpfunc);
    printf("\nSorted temp array: ");
    for(int x=0;x<i;x++)
    {
        printf("%d ",temp[x]);
    }
    int pos=0;
    reinorder(root,&pos);
    printf("\nInorder traversal after reordered: ");
    inorder(root);
}


