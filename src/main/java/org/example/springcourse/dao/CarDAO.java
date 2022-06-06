package org.example.springcourse.dao;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.BeanPropertyRowMapper;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.stereotype.Component;
        import org.example.springcourse.models.Car;
        import java.util.List;

@Component
public class CarDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Car> index() {
        return jdbcTemplate.query("SELECT * FROM Car", new BeanPropertyRowMapper<>(Car.class));
    }

    public Car show(int id) {
        return jdbcTemplate.query("SELECT * FROM car WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Car.class))
                .stream().findAny().orElse(null);
    }

    public void save(Car car) {
        jdbcTemplate.update("INSERT INTO car(brand, model,createdDate, engineVolume) VALUES(?,?,?,?)", car.getBrand(), car.getModel(), car.getCreatedDate(),car.getEngineVolume());
    }

    public void update(int id, Car updatedCar) {
        jdbcTemplate.update("UPDATE car SET brand=?, model=?, createdDate=?, engineVolume=? WHERE id=?",
                updatedCar.getBrand(), updatedCar.getModel(), updatedCar.getCreatedDate(), updatedCar.getEngineVolume(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Car WHERE id=?",id);
    }
}