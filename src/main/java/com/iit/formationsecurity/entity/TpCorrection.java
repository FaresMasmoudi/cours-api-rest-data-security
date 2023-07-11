package com.iit.formationsecurity.entity;

import jakarta.persistence.*;
import lombok.*;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "TP_CORRECTION")
public class TpCorrection {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="TC_ID")
    private Long tcId;
    @Column(name="TC_CORRECTION")
    private String tcCorrection;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TP_ID")
    TP tp;
}
