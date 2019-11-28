class Ternary{
public static void main (String []args){
int a=10;
int b=30;
int c=40;
int num=a>b?(a>c?a:(b>c?b:c)):c;
int n=a>b && a>c ?a:b>c?b:c;
System.out.println(num);
System.out.println(n);
}
}