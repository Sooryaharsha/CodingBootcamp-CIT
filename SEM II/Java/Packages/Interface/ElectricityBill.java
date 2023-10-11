package Java.Packages.Interface;


 class ElectricityBill implements DomesticInterface,CommercialInterface {

    String customerName,userPurpose;
    Double lastMonthReading,currentMonthReading;
    Double totAmount,totalUnits;
    static int billNo;

    ElectricityBill(){
        customerName = "";
        userPurpose = "";
        lastMonthReading =0.0;
        currentMonthReading = 0.0;
        totalUnits = 0.0;
        totAmount=0.0;
    }

    ElectricityBill(String customerName,Double lastMonthReading,Double currentMonthReading,String userPurpose){

        this.customerName = customerName;
        this.lastMonthReading = lastMonthReading;
        this.currentMonthReading = currentMonthReading;
        this.userPurpose = userPurpose;
        billNo++;

    }

    public void findTotalAmount()
    {
        if(userPurpose.toLowerCase().equals(userType1)){

            if(totalUnits < 100 ){
                totAmount = totalUnits * domesticCostPerUnit; 
                
            }
            else if(totalUnits < 200 ){
                totAmount = (100*domesticCostPerUnit) +(totalUnits-100 )*(domesticCostPerUnit*2); 
                
        }
        else if(totalUnits>=200){
            totAmount = (100*domesticCostPerUnit) +(totalUnits-100 )*(domesticCostPerUnit*2) + (totalUnits-100 )*(domesticCostPerUnit*2);
           
        }
    }

        else{

            if(totalUnits <100 ){
                totAmount = totalUnits * commercialCostPerUnit; 
            }
            else if(totalUnits < 200 ){
                totAmount = (100*commercialCostPerUnit) +(totalUnits-100 )*(commercialCostPerUnit*2); 
        }
        else if(totalUnits>=200){
            totAmount = (100*commercialCostPerUnit) +(totalUnits-100 )*(commercialCostPerUnit*2) + (totalUnits-100 )*(commercialCostPerUnit*2);
            System.out.println("Commercial"+totalUnits+" "+totAmount);
        }
    }
 }


    public void findTotalUnit()
    {
        totalUnits =  currentMonthReading - lastMonthReading;
    }
    
    public void printBill()
    {

        System.out.println("\n\n----------------------------------------------------------------------------------------");
        System.out.println("CustomerName \t BillNo \t Purpose \t Consumed Units \t Total Cost ");
        System.out.println("----------------------------------------------------------------------------------------");
        
        System.out.println(customerName+"\t\t"+billNo+"\t\t"+userPurpose+"\t\t"+totalUnits+"\t\t"+totAmount);
        System.out.println("----------------------------------------------------------------------------------------\n\n");

}
 }