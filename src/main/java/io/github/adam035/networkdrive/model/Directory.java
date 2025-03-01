package io.github.adam035.networkdrive.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "directories")
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("DIRECTORY")
public class Directory extends Item {

    @Column(name = "is_root")
    private boolean isRoot;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "parentDirectory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;
}
