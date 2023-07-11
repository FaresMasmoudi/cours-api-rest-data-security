package com.iit.formationsecurity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FORMATION")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORMATION_ID")
    private Long id;
    @Column(name = "FORMATION_THEME")
    private String theme;
    @OneToOne
    @JoinColumn(name="detailId")
    @RestResource(path = "formationDetail", rel="detail")
    private FormationDetail formationDetail;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "FORMATIONS_TPS",
            joinColumns = @JoinColumn(
                    name = "FORMATION_ID", referencedColumnName = "FORMATION_ID"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "TP_ID", referencedColumnName = "TP_ID"
            )
    )
    private List<TP> tps;

}