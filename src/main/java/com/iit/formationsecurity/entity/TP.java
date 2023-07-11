package com.iit.formationsecurity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "TP")
public class TP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TP_ID")
    Long tpId;
    @Column(name="TP_SUJET")
    String tpSujet;
    @Column(name="TP_DUREE")
    Long tpDuree;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="tp")
    private List<TpCorrection> TpCorrections;

    @ManyToMany(mappedBy="tps", cascade = CascadeType.ALL)
    private List<Formation> formations;

}