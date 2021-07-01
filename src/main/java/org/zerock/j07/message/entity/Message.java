package org.zerock.j07.message.entity;

import lombok.*;
import org.zerock.j07.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_message")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(nullable = false, length = 255)
    private String content;

    @Column(nullable = false, length = 15)
    private String sender;

    @Column(nullable = false, length = 15)
    private String receiver;

    private boolean status;

    public void changeStatus(boolean status){

        this.status = status;
    }





}
