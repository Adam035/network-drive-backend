package io.github.adam035.networkdrive.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "files")
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("FILE")
public class File extends Item {
    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String md5;

    @Column(nullable = false)
    private String sha1;

    @Column(nullable = false)
    private String sha256;

    @Column(nullable = false)
    private int size;
}
