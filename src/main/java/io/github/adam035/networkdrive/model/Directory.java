package io.github.adam035.networkdrive.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "directories")
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "directory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> files;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "parentDirectory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Directory> subdirectories;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Directory parentDirectory;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany
    @JoinTable(
            name = "directory_shares",
            joinColumns = @JoinColumn(name = "directory_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> sharedWithUsers;
}
