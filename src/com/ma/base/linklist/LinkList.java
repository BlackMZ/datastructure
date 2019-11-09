package com.ma.base.linklist;

import java.util.Scanner;

/**
 * @Author: John.ma
 * @Description:
 * @Date: 2019/10/28 13:57
 */
class Data {
    String key;
    String name;
    int age;
}

class Nodes {
    Data data = new Data();
    Nodes nextNode;

    Nodes addEnd(Nodes head, Data data) {
        Nodes node, htemp;
        if (null == (node = new Nodes())) {
            System.out.println("申请内存失败!");
            return null;
        } else {
            node.data = data;
            node.nextNode = null;
            if (head == null) {
                head = node;
                return head;
            }
            htemp = head;
            while (htemp.nextNode != null) {
                htemp = htemp.nextNode;
            }
            htemp.nextNode = node;
            return head;
        }

    }

    Nodes addFirst(Nodes head, Data data) {
        Nodes node = new Nodes();
        if (node == null) {
            System.out.println("申请内存失败!");
            return null;
        } else {
            node.data = data;
            node.nextNode = head;
            head = node;
            return head;
        }
    }

    Nodes findNode(Nodes head, String key) {
        Nodes htemp = head;
        while (htemp != null) {
            if (htemp.data.key.compareTo(key) == 0) {
                return htemp;
            }
            htemp = htemp.nextNode;
        }
        return null;
    }

    Nodes insertNode(Nodes head, String findKey, Data data) {
        Nodes node = new Nodes();
        if (node == null) {
            System.out.println("申请内存失败");
            return null;
        }
        node.data = data;
        Nodes nodeTemp = findNode(head, findKey);
        if (nodeTemp != null) {
            node.nextNode = nodeTemp.nextNode;
            nodeTemp.nextNode = node;
        } else {
            System.out.println("未找到正确的插入位置！");
        }
        return head;
    }

    int deleteNode(Nodes head, String key) {
        Nodes node = head;
        Nodes htemp = head;
        while (htemp != null) {
            if (htemp.data.key.compareTo(key) == 0) {
                node.nextNode = htemp.nextNode;
                return 1;
            } else {
                node = htemp;
                htemp = htemp.nextNode;
            }
        }
        return 0;
    }

    int length(Nodes head) {
        int length = 0;
        Nodes htemp = head;
        while (htemp != null) {
            length++;
            htemp = htemp.nextNode;
        }
        return length;
    }

    void allNode(Nodes head) {
        Nodes htmp = head;
        Data data = new Data();
        System.out.printf("当前链表共有%d个结点。链表所有数据如下：\n",length(head));
        while (htmp != null) {
            data = htmp.data;
            System.out.printf("结点(%s,%s,%d)\n",data.key,data.name,data.age);
            htmp = htmp.nextNode;
        }
    }
}

public class LinkList {
    public static void main(String[] args) {
        Nodes node, head=null;
        Nodes CL=new Nodes();
        String key,findkey;
        Scanner input=new Scanner(System.in);

        System.out.print("链表测试。先输入链表中的数据，格式为：关键字 姓名 年龄\n");
        do
        {
            Data nodeData=new Data();
            nodeData.key=input.next();
            if(nodeData.key.equals("0"))
            {
                break; //若输入0，则退出
            }
            else
            {
                nodeData.name=input.next();
                nodeData.age=input.nextInt();
                head=CL.addEnd(head,nodeData);//在链表尾部添加结点
            }
        }while(true);
        CL.allNode(head); 							//显示所有结点

        System.out.printf("\n演示插入结点，输入插入位置的关键字：") ;
        findkey=input.next();  						//输入插入位置关键字
        System.out.print("输入插入结点的数据(关键字 姓名 年龄):");
        Data nodeData=new Data();
        nodeData.key=input.next();
        nodeData.name=input.next();
        nodeData.age=input.nextInt();//输入插入结点数据
        head=CL.insertNode(head,findkey,nodeData);		//调用插入函数
        CL.allNode(head); 							//显示所有结点

        System.out.print("\n演示删除结点，输入要删除的关键字:");

        key=input.next();								//输入删除结点关键字
        CL.deleteNode(head,key); 					//调用删除结点函数
        CL.allNode(head); 							//显示所有结点

        System.out.printf("\n演示在链表中查找，输入查找关键字:");
        key=input.next();							//输入查找关键字
        node=CL.findNode(head,key);					//调用查找函数，返回结点指针
        if(node!=null)									//若返回结点指针有效
        {
            nodeData=node.data;				//获取结点的数据
            System.out.printf("关键字%s对应的结点为(%s,%s,%d)\n" ,key,nodeData.key,nodeData.name,nodeData.age);
        }
        else										//若结点指针无效
        {
            System.out.printf("在链表中未找到关键字为%s的结点！\n",key);
        }
    }
}
