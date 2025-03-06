package edu.romoshi.diary.service;

import edu.romoshi.diary.entity.Habit;
import edu.romoshi.diary.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitService {

    final HabitRepository habitRepository;

    @Autowired
    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public Optional<Habit> getHabitById(Long id) {
        return habitRepository.findById(id);
    }

    public Habit saveHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public Optional<Habit> updateHabit(Long id, Habit habitDetails) {
        return habitRepository.findById(id)
                .map(habit -> {
                    habit.setDescription(habitDetails.getDescription());
                    habit.setFrequency(habitDetails.getFrequency());
                    return habitRepository.save(habitDetails);
                });
    }

    public void deleteHabit(Long id) {
        habitRepository.deleteById(id);
    }
}
