

import java.util.*;

/**
 * Created by uchaudh on 7/10/2015.
 */
public class VoiletGeeks_Umesh_ItemPacker {

    /**
     * Static Global Variables
     */
   static String givenMaxWeight= null;
   static String givenMaxUnit= null;
    /**
     * TreeMap<String,List<String>> type to accommodate skewed values e.g. multiple values for a key
     */
   static TreeMap<String,List<String>> givenItems=new  TreeMap<String, List<String>>();
    /**
     * List<Map<String,List<String>>> type for list of bags and bags are of Map<String,List<String>> type
     */
   static List<Map<String,List<String>>> bags= new ArrayList<Map<String, List<String>>>();
    /**
     * List<Map<String,List<String>>> type for list of vacant bags which are subsequent to actual bags (Proxy Bags)
     */
    static List<Map<String,List<String>>> vacancyInBags= new ArrayList<Map<String, List<String>>>();
    /**
     * Flag to check weather item is accommodated in existing bag or it needs a new bag
     */
    static boolean accomodatedInExistingBag=false;


    /**
     * main method(Entry Point of Program)
     * @param args
     */
    public static void main(String[] args) {

        try{

            givenMaxWeight= args[0].split(":")[0];
            givenMaxUnit= args[0].split(":")[1];

            String[] purchasedProducts=  args[1].split(",");

            for (String items:purchasedProducts)
            {
                add(givenItems,items.split(":")[0], items.split(":")[1]);
            }

            /**
             * Invoking pluggable method to apply business logic
             */
            arrangeProductsInBags();


            /**
             * logic to generate the expected output
             */
            StringBuilder sb=new StringBuilder();
            int bagCount=0;
            for (Map<String,List<String>> itemsInBag: bags)
            {
                int itemCount=0;
                if(bagCount>0)
                sb.append("|");
                for(String key: itemsInBag.keySet())
                {
                    List<String> unitsForWeight= itemsInBag.get(key);
                    for(String unit: unitsForWeight)
                    {
                        if(itemCount>0)
                        sb.append(",");
                        sb.append(key);
                        sb.append(":"+unit);
                        itemCount++;
                    }
                }
                bagCount++;
            }

            System.out.println( sb.toString());

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     *Method responsible for arranging items in bags
     */
    private  static void arrangeProductsInBags()
    {

        Iterator<String> it = givenItems.descendingKeySet().iterator();

        while (it.hasNext())
        {
            String itemWeight=it.next();
            if(Integer.parseInt(itemWeight)<=Integer.parseInt(givenMaxWeight) )
            {
//                List<String> unitsForWeight= givenItems.get(itemWeight);
                List<String> unitsForWeight = givenItems.get(itemWeight);
                Iterator<String> ie= unitsForWeight.iterator();
                while(ie.hasNext())
                {
                    String unit= ie.next();
                    if (bags.size() > 0)
                        accomodatedInExistingBag = tryToFitItemInExistingBag(itemWeight, unit);

                    if (!accomodatedInExistingBag) {
                        Map<String, List<String>> newBag = new HashMap<String, List<String>>();
                        add(newBag, itemWeight, unit);
                        Map<String, List<String>> newVacancyBag = new HashMap<String, List<String>>();
                        add(newVacancyBag, Integer.toString(Integer.parseInt(givenMaxWeight) - Integer.parseInt(itemWeight)), Integer.toString(Integer.parseInt(givenMaxUnit) - Integer.parseInt(unit)));
                        bags.add(newBag);
                        vacancyInBags.add(newVacancyBag);
                        removeAllocatedItem( itemWeight,unit);
                    }
                    else {

                    }
                }
            }

        }
    }

    /**
     * Method to accommodate items in existing bag
     * @param weight
     * @param units
     * @return
     */
    private static boolean tryToFitItemInExistingBag(String weight, String units)
    {
        int index=0;
        accomodatedInExistingBag=false;

        for(Map<String,List<String>> vacantBag: vacancyInBags)
        {
            for (String presentVacantWeight: vacantBag.keySet())
            {
                searchForBestFit(vacantBag, presentVacantWeight, weight,units,index);

                if(Integer.parseInt(weight)<= Integer.parseInt(presentVacantWeight))
                {
                    if(sum( vacantBag.get(presentVacantWeight)) - Integer.parseInt( units) >= 0)
                    {
                        add(bags.get(index),weight,units);
//                        remove(vacantBag,presentVacantWeight,"");

                        decrement(vacantBag, presentVacantWeight,weight,units);
                        accomodatedInExistingBag=true;
                    }
                }
            }
            index++;
        }
        return accomodatedInExistingBag;
    }


    /**
     * Implementation for adding an element in Map<String,List<String>>
     * @param map
     * @param key
     * @param newValue
     */
    public static void add(Map<String,List<String>> map,String key, String newValue) {
        List<String> currentValue = map.get(key);
        if (currentValue == null) {
            currentValue = new ArrayList<String>();
            map.put(key, currentValue);
        }
        currentValue.add(newValue);
    }


    /**
     * Implementation for decrementing the key and value by specified values in a Map <String,List<String>>
     * @param map
     * @param key
     * @param decreasebykey
     * @param decreasebyvalue
     */
    public static void decrement(Map <String,List<String>> map,String key, String decreasebykey, String decreasebyvalue)
    {
        List<String> units= map.get(key);
        map.put(Integer.toString(Integer.parseInt(key)-Integer.parseInt(decreasebykey)), Arrays.asList( Integer.toString(Integer.parseInt(units.get(0))-Integer.parseInt(decreasebyvalue))));
        units.remove(units.get(0));
        map.remove(key);
    }




    /**
     * Implementation to add the values for a key in List<String>
     * @param stringList
     * @return
     */
    public static int sum(List<String> stringList)
    {
        int sum = 0;
        for(String d : stringList)
            sum += Integer.parseInt(d);
        return sum;
    }

    public static void removeAllocatedItem(String itemWeight, String unit)
    {
        List<String> values= givenItems.get(itemWeight);
        if(values != null)
        {
            values.remove(unit);
            givenItems.put(itemWeight,values);
        }
        else
        {
            givenItems.remove(itemWeight);
        }
    }


    public static void searchForBestFit(Map<String,List<String>> vacantBag, String presentVacantWeight, String weight, String units,int index)
    {
       for(String item: givenItems.keySet())
       {
           if(Integer.parseInt( item) <= Integer.parseInt(weight))
           {
               List<String> unitCollection = givenItems.get(item);
               Collections.reverse(unitCollection);
               if (unitCollection.contains(units))
               {
                   add(bags.get(index), item, units);
                   decrement(vacantBag, presentVacantWeight, weight, units);
                   accomodatedInExistingBag = true;
                   removeAllocatedItem(weight, units);
               }
               else {
                   for (String s : unitCollection) {
                       if (Integer.parseInt(s) <= Integer.parseInt(units))
                       {   add(bags.get(index), item, units);
                           decrement(vacantBag, presentVacantWeight, weight, units);
                           accomodatedInExistingBag = true;
                           removeAllocatedItem(weight, units);
                       }
                   }
               }
           }

       }

        }
    }





