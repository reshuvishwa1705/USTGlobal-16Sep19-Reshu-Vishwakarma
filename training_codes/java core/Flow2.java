class Flow2{
public static void main(String []args){
double bmi=40;
if(bmi<18.5){
System.out.println("You are in the underweight");
}
else if(bmi>=18.5  && bmi<=24.9){
System.out.println("You are in the healthy weight");
}
else if(bmi>=25 && bmi<=29.9){
System.out.println("You are in the overweight");
}
else if(bmi>=30 && bmi<=39.9){
System.out.println("You are in the obeseweight");
}

else {
System.out.println("Invalid Range");
}

}
}