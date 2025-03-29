package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "region_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionEntity {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

}
