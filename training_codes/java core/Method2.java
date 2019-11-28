class Method2{
public static void main (String []args){
double num= areaOfCircle(2.5);
System.out.println("Area of Circle "+num);
double cir=circumOfCircle(3.6);
System.out.println("Circumference of Circle "+cir);
boolean b=oddEven(55);
if(b)
System.out.println("Even Number");
else
System.out.println("Odd Number");
int f=fact(5);
System.out.println("Factorial of a number is "+f);
greeting("Hello Ghatiya aurat Anuska");
}
static double areaOfCircle(double r){
return 3.14*r*r;
}
static double circumOfCircle(double r){
return 3.14*r*2;
}
static boolean oddEven(int n){
if(n%2==0)
return true;
else 
return false;
}
static int fact(int n){
int f=1;
for(int i=1;i<=n;i++){
f=f*i;
}
return f;
}
static void greeting(String msg){
System.out.println(msg);
}

}