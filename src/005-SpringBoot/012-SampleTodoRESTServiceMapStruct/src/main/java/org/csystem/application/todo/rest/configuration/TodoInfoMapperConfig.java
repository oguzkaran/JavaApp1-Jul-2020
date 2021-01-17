package org.csystem.application.todo.rest.configuration;

import org.csystem.application.todo.rest.mapper.ITodoInfoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoInfoMapperConfig {
    @Bean
    public ITodoInfoMapper getTodoInfoMapper()
    {
        return Mappers.getMapper(ITodoInfoMapper.class);
    }
}
