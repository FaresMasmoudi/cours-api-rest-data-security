package com.iit.formationsecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FORMATION_DETAIL")
public class FormationDetail {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="FD_ID")
    private Long fdId;
    @Column(name="FD_TABLE_MATIERE")
    private String fdTableMatiere;
    @Column(name="FD_SUPPORT_PDF")
    private String fdSupportPDF;

    @OneToOne(mappedBy = "formationDetail")
    private Formation formation;

}
