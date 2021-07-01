package org.zerock.j07.board.entity;

import lombok.*;
import org.zerock.j07.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_board")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    private String writer;
}
