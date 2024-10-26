package com.ge.view;

/*Projection : It is a mechanism to select and retrieve only specific subsets of fields from an entity.*/
/*Dynamic Projection : Dynamic projections allow clients to define projection at runtime.*/
/*Advantages of Projection :
    1. When you use projections, the SQL query generated by the Spring Data JPA only selects the specified fields in interface(ResultView in this case). This can lead to significant performance improvements especially when dealing with large entities with many fields.
    2. By retrieving only needed fields, you reduce the amount of data held in the memory.
*/
public interface View {

}
