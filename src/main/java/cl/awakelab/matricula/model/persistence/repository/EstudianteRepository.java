package cl.awakelab.matricula.model.persistence.repository;

import cl.awakelab.matricula.model.domain.dto.Student;
import cl.awakelab.matricula.model.domain.repository.StudentRepository;
import cl.awakelab.matricula.model.persistence.crud.EstudianteCrud;
import cl.awakelab.matricula.model.persistence.entity.Estudiante;
import cl.awakelab.matricula.model.persistence.mapper.StudentMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class EstudianteRepository implements StudentRepository {

    private final EstudianteCrud crud;
    private final StudentMapper mapper;

    public EstudianteRepository(EstudianteCrud crud, StudentMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Student>> findAll() {
        return Optional.of(mapper.toStudents((List<Estudiante>) crud.findAll()));
    }

    @Override
    public Optional<Student> findById(int studentId) {
        return crud.findById(studentId)
                .map(mapper::toStudent);
    }

    @Override
    public Student save(Student student) {
        return mapper.toStudent(crud.save(mapper.toEstudiante(student)));
    }

    @Override
    public void delete(int studentId) {
        crud.deleteById(studentId);
    }
}
