package org.zerock.j07.message.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

    private Long mno;
    private String content;
    private String sender;
    private String receiver;
    private boolean status;


}
