package inha.capstone.ppanggeure.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@ToString(exclude = {"breadTags"})
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Bread extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bread_id")
    private Long id;

    @Column(length = 30, nullable = false)
    private String breadName;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String detailAddress;

    private Long editorId;

    private String editorEval;

    @Column(length = 13, nullable = false)
    private String phone;

    @Column(length = 15)
    private String priceRange;

    @Column(length = 20)
    private String openingHours;

    @Column(length = 20)
    private String breakTime;

    @Column(length = 20)
    private String lastOrder;

    @Column(length = 20, nullable = false)
    private String lat;

    @Column(length = 20, nullable = false)
    private String lng;

    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinTable(name = "bread_tags", joinColumns = { @JoinColumn(name = "bread_id") }, inverseJoinColumns = {
            @JoinColumn(name = "tag_id") })
    private List<Tag> breadTags = new ArrayList<>();
}
