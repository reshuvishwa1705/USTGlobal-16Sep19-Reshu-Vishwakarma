class Pool{
public static void main(String []args){
int x=0;
while(x<4){
System.out.print("");
if(x<1){
System.out.print("a");
x=x+1;
}
if(x>0){
System.out.println(" ");
x=x-1;
}
if(x==1){
System.out.println("noise");
x=x+2;
}
if(x>3){
System.out.println("");
}
System.out.println("");

}
}
}
