package inha.capstone.ppanggeure.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class BreadRequest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breq_id")
    private Long id;

    @Column(length = 30, nullable = false)
    private String breadName;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String detailAddress;

    @Column(length = 13, nullable = false)
    private String phone;

    @Column(nullable = false)
    private Long writerId;

}
