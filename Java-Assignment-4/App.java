/*class Outer{
    private String message="Hello";
    class Inner{
        void display(){
            System.out.println(message);
        }
    }
}
*/
interface Hello{
    void display();
}
class AnomMain implements Hello{
    public void display(){
        System.out.println("hello");
    }
    public static void main(String[] args) {
        
    }
}