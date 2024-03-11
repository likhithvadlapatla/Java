public class BlueDart implements DeliveryService{

    static{
        System.out.println("BlueDart class is loaded.");
    }

    BlueDart(){
        System.out.println("BlueDart bean is created.");
    }

    @Override
    public Boolean deliverProduct(Double amount) {
        System.out.println("Product delivered through BlueDart and amount paid is : "+amount);
        return true;
    }
}
