import java.util.*;
import java.lang.*;

//class that represents BST tree for the words in the dictionary
public class BST implements Storage
{
    Node root;

    public BST() //constructor
    {
        root = null;
    }

    public void insert(String str)
    {
        Node newNode = new Node(str);
        if(root == null) //it start of tree insert the node
        {
			root = newNode;
		}
        else //if not then loop to go deeper
        {
            Node current = root;
            boolean running = true;
			while(running) //loops to add to right place
			{
				if(current.data.compareTo(newNode.data) > 0) //test left side
				{
                    if(current.left == null)
                    {
						current.left = newNode;
						break;
					}
                    else
                    {
						current = current.left;
                    }
				}
                else //if not on left then right
                {
                    if(current.right == null)
                    {
						current.right = newNode;
						break;
					}
                    else
                    {
						current = current.right;
                    }
				}
			}
		}
    }
    
    public boolean find(String str)//return boolean for finding strings
    {
        Node current = root;
        boolean running = true;
        while(running)
        {
			
            if(current == null)//If the current one is null, it means the word doesn't exists, so false
            {
                return false;
            }
            else //if not null then it check the current node to see if its right. then checks to go left or right
            {
                if(current.data.equals(str)) //if it is the right node then return true
                {
                    return true;
                }
                if(current.data.compareTo(str) < 0) //if current is less go down the right side
                {
                    current = current.right;
                }
                else //if not right then left
                {
                    current = current.left;
                }
			}
        }
        return false;
	}


    public String toString()
    {
        return "BST";
    }

    class Node
    {
        String data;
        Node left;
        Node right;

        Node(String item)
        {
            data = item;
            left = null;
            right = null;
        }
    }
}
