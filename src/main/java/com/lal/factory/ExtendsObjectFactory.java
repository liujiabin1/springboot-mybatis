package com.lal.factory;

import com.lal.entity.User;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class ExtendsObjectFactory extends DefaultObjectFactory {

    @Override
    public <T> T create(Class<T> type) {
        T t = super.create(type);

        if(User.class.equals(type)) {
            User user = (User) t;
            user.setAge(0);
        }
        return t;
    }

}
