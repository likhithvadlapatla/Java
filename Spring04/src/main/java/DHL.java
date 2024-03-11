public class DHL implements DeliveryService{

    static{
        System.out.println("DHL class is loaded.");
    }

    DHL(){
        System.out.println("DHL bean is created.");
    }



    @Override
    public Boolean deliverProduct(Double amount) {
        System.out.println("Product delivered through DHL and amount paid is : "+amount);
        return true;
    }
}
