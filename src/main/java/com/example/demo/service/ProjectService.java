package com.example.demo.service;

import com.example.demo.dto.ProjectFilterDTO;
import com.example.demo.entity.Project;
import com.example.demo.entity.QProject;
import com.example.demo.repository.ProjectRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProjectRepository projectRepository;

    public Project getById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

    public void createTask(Project project) {
        projectRepository.save(project);
    }

    public void updateById(Project project, Long id) {
        Project old = projectRepository.getById(id);
        old.setName(project.getName());
        old.setStatus(project.getStatus());
        old.setPriority(project.getPriority());
        old.setStartDate(project.getStartDate());
        old.setComplDate(project.getComplDate());
        projectRepository.save(old);
    }
    //filter
    public List<Project> filter(ProjectFilterDTO dto) {
        QProject qProject = QProject.project;
        BooleanBuilder whereBuilder = new BooleanBuilder();
        JPAQuery<Project> jpaQuery=new JPAQuery<>(entityManager);
        //filter by name
        if (dto.getName()!=null){
            whereBuilder.and(qProject.name.startsWithIgnoreCase(dto.getName())).or(qProject.name.endsWithIgnoreCase(dto.getName()));
        }
        //filter by priority
        if(dto.getPriority()!=0) {
            whereBuilder.and(qProject.priority.eq(dto.getPriority()));
        }
        //filter by status
        if (dto.getStatus()!=null){
            whereBuilder.and(qProject.status.eq(dto.getStatus()));
        }
        jpaQuery.select(
                Projections.fields(
                        Project.class,
                        qProject.id,
                        qProject.name,
                        qProject.complDate,
                        qProject.priority,
                        qProject.status,
                        qProject.startDate
                )
        ).from(qProject)
                .where(whereBuilder);
//                .orderBy(new OrderSpecifier<>(Order.DESC,dto.getSort()));
        return jpaQuery.fetch();

    }

    public List<Project> getAll() {
        return projectRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
