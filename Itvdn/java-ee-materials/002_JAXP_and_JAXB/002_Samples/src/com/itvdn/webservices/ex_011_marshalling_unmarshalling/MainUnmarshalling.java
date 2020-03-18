package com.itvdn.webservices.ex_011_marshalling_unmarshalling;



import com.itvdn.webservices.ex_011_marshalling_unmarshalling.country.CountryType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Asus on 08.12.2017.
 */
public class MainUnmarshalling {

    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CountryType.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        CountryType countryTypes =(CountryType) unmarshaller.unmarshal(new File("out.xml"));


            System.out.println(countryTypes.getName() + " " + countryTypes.getCapital()
                    + " " + countryTypes.getCountryCode() + " " + countryTypes.getDescription());



    }

}
