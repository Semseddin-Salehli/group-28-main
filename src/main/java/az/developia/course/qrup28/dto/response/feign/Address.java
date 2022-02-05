package az.developia.course.qrup28.dto.response.feign;

import lombok.Data;

@Data
public class Address {
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;
}
