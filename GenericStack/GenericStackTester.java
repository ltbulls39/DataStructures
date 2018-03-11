public class GenericStackTester {
    public static void main(String [] args) {
        GenericStack<Integer> gStack = new GenericStack<>();


        System.out.println("Size: " + gStack.size());

        
        gStack.push(3);
        gStack.push(6);
        gStack.push(9);
        gStack.push(12);

        System.out.println("Size: " + gStack.size());

        System.out.println(gStack.pop());
        System.out.println(gStack.pop());


    }

}