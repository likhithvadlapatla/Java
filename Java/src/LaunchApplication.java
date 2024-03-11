public class LaunchApplication {
    public static void main(String[] args){
        System.out.println("Welcome to our first loosely coupled application");

        /*Constructor Dependency Injection*/
        AmazonApplication amz = new AmazonApplication(new BlueDart());

        /*
        // Setter Dependency Injection
        amz.setService(new DHL());
        */

        Boolean status = amz.deliverTheProduct(5000.00);
        if(status)
            System.out.println("Product Delivered Successfully");
        else
            System.out.println("Failed to deliver the product");
    }
}
