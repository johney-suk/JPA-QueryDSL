package org.zerock.j07.message.repository.dynamic;

import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.j07.message.entity.Message;
import org.zerock.j07.message.entity.QMessage;

import java.util.List;


@Log4j2
public class MessageDslImpl extends QuerydslRepositorySupport implements MessageDsl {


    public MessageDslImpl() {
        super(Message.class);
    }

    @Override
    public Page<Message> readMessage( Pageable pageable) {

        QMessage message = QMessage.message;

        JPQLQuery<Message> query = from(message);

        query.where(message.status.eq(true));
        query.orderBy(message.mno.desc());

        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());


        List<Message> list = query.fetch();
        long count = query.fetchCount();


        return new PageImpl<>(list,pageable,count);
    }


}
