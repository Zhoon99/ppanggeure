package inha.capstone.ppanggeure.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString(exclude = {"posts"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Column(length = 10, nullable = false)
    private String tagName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "breadTags")
    private List<Bread> posts = new ArrayList<>();
}
