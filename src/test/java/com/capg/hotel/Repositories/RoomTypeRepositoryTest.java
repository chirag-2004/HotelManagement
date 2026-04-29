package com.capg.hotel.Repositories;

import com.capg.hotel.entities.RoomType;
import com.capg.hotel.repositories.RoomTypeRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class RoomTypeRepositoryTest {

    @Autowired
    private RoomTypeRepository repository;

    // 🔧 Helper
    private RoomType createRoomType(String typeName, String description, Integer maxOccupancy,
			double price) {
        RoomType rt = new RoomType();
        rt.setTypeName(typeName);
        rt.setMaxOccupancy(maxOccupancy);
        rt.setPricePerNight(BigDecimal.valueOf(price));
        rt.setDescription(description);
        return repository.save(rt);
    }

    // =========================
    // 🔹 BASIC CRUD (MINIMAL)
    // =========================

    @Test
    @DisplayName("save persists entity successfully")
    void save_validRoomType_persistsSuccessfully() {
    	RoomType saved = createRoomType("Double", "Double bed room", 2, 80.00);

        assertThat(saved.getRoomTypeId()).isNotNull();
    }

//    @Test
//    void findById_existingId_returnsEntity() {
//
//        Optional<RoomType> result = repository.findById(2);
//
//        assertThat(result).isPresent();
//    }
//
//    @Test
//    void findById_nonExistingId_returnsEmpty() {
//        Optional<RoomType> result = repository.findById(999);
//
//        assertThat(result).isEmpty();
//    }
//
//    @Test
//    void findAll_returnsAllRecords() {
//    	RoomType saved = createRoomType("A", "Double bed room", 2, 80.00);
//    	RoomType saved1 = createRoomType("B", "Single bed room", 1, 100.00);
//
//        List<RoomType> result = repository.findAll();
//
//        assertThat(result).hasSize(2);
//    }
//
//    @Test
//    void deleteById_removesEntity() {
//    	RoomType saved = createRoomType("Double", "Double bed room", 2, 80.00);
//
//        repository.deleteById(saved.getRoomTypeId());
//
//        assertThat(repository.findById(saved.getRoomTypeId())).isEmpty();
//    }
//
//    // =========================
//    // 🔹 findByTypeName
//    // =========================
//
//    @Test
//    void findByTypeName_exactMatch_returnsResult() {
//    	RoomType saved = createRoomType("Double", "Double bed room", 2, 80.00);
//
//        List<RoomType> result = repository.findByTypeName("Deluxe");
//
//        assertThat(result).hasSize(1);
//        assertThat(result.get(0).getTypeName()).isEqualTo("Deluxe");
//    }
//
//    @Test
//    void findByTypeName_noMatch_returnsEmpty() {
//    	RoomType saved = createRoomType("Double", "Double bed room", 2, 80.00);
//
//        List<RoomType> result = repository.findByTypeName("Suite");
//
//        assertThat(result).isEmpty();
//    }
//
//    // =========================
//    // 🔹 findByMaxOccupancyGreaterThan
//    // =========================
//
//    @Test
//    void findByMaxOccupancyGreaterThan_returnsOnlyGreaterValues() {
//    	RoomType saved = createRoomType("A", "Double bed room", 2, 80.00);
//    	RoomType saved1 = createRoomType("B", "Single bed room", 1, 100.00);
//
//        List<RoomType> result = repository.findByMaxOccupancyGreaterThan(2);
//
//        assertThat(result).hasSize(1);
//        assertThat(result.get(0).getMaxOccupancy()).isGreaterThan(2);
//    }
//
//    @Test
//    void findByMaxOccupancyGreaterThan_boundary_excludesEqual() {
//    	RoomType saved = createRoomType("A", "Double bed room", 2, 80.00);
//    	RoomType saved1 = createRoomType("B", "Single bed room", 1, 100.00);
//
//
//        List<RoomType> result = repository.findByMaxOccupancyGreaterThan(2);
//
//        assertThat(result)
//                .extracting(RoomType::getMaxOccupancy)
//                .allMatch(val -> val > 2);
//    }
//
//    @Test
//    void findByMaxOccupancyGreaterThan_noMatch_returnsEmpty() {
//    	RoomType saved = createRoomType("A", "Double bed room", 2, 80.00);
//    	RoomType saved1 = createRoomType("B", "Single bed room", 1, 100.00);
//
//
//        List<RoomType> result = repository.findByMaxOccupancyGreaterThan(5);
//
//        assertThat(result).isEmpty();
//    }
//
//    // =========================
//    // 🔹 findByPricePerNightLessThan
//    // =========================
//
//    @Test
//    void findByPricePerNightLessThan_returnsOnlyLowerPrices() {
//    	RoomType saved = createRoomType("A", "Double bed room", 2, 80.00);
//    	RoomType saved1 = createRoomType("B", "Single bed room", 1, 100.00);
//
//
//        List<RoomType> result =
//                repository.findByPricePerNightLessThan(BigDecimal.valueOf(2000));
//
//        assertThat(result).hasSize(1);
//        assertThat(result.get(0).getPricePerNight())
//                .isLessThan(BigDecimal.valueOf(2000));
//    }
//
//    @Test
//    void findByPricePerNightLessThan_boundary_excludesEqual() {
//    	RoomType saved = createRoomType("A", "Double bed room", 2, 80.00);
//    	RoomType saved1 = createRoomType("B", "Single bed room", 1, 100.00);
//
//
//        List<RoomType> result =
//                repository.findByPricePerNightLessThan(BigDecimal.valueOf(2000));
//
//        assertThat(result).isEmpty();
//    }
//
//    @Test
//    void findByPricePerNightLessThan_noMatch_returnsEmpty() {
//    	RoomType saved = createRoomType("A", "Double bed room", 2, 80.00);
//    	RoomType saved1 = createRoomType("B", "Single bed room", 1, 100.00);
//
//
//        List<RoomType> result =
//                repository.findByPricePerNightLessThan(BigDecimal.valueOf(1000));
//
//        assertThat(result).isEmpty();
//    }
//
//    // =========================
//    // 🔹 findByTypeNameContaining
//    // =========================
//
//    @Test
//    void findByTypeNameContaining_partialMatch_returnsResults() {
//    	RoomType saved = createRoomType("A", "Double bed room", 2, 80.00);
//    	RoomType saved1 = createRoomType("B", "Single bed room", 1, 100.00);
//
//
//        List<RoomType> result =
//                repository.findByTypeNameContaining("Room");
//
//        assertThat(result).hasSize(2);
//    }
//
//    @Test
//    void findByTypeNameContaining_noMatch_returnsEmpty() {
//    	RoomType saved = createRoomType("A", "Double bed room", 2, 80.00);
//
//        List<RoomType> result =
//                repository.findByTypeNameContaining("XYZ");
//
//        assertThat(result).isEmpty();
//    }
//
//    @Test
//    void findByTypeNameContaining_emptyString_returnsAllRecords() {
//    	RoomType saved = createRoomType("A", "Double bed room", 2, 80.00);
//    	RoomType saved1 = createRoomType("B", "Single bed room", 1, 100.00);
//
//        List<RoomType> result =
//                repository.findByTypeNameContaining("");
//
//        assertThat(result).hasSize(2);
//    }
//
//    // =========================
//    // 🔹 DATA INTEGRITY / CONSTRAINT
//    // =========================
//
//    @Test
//    void save_duplicateTypeName_throwsException() {
//    	RoomType saved = createRoomType("A", "Double bed room", 2, 80.00);
//
//        RoomType duplicate = new RoomType();
//        duplicate.setTypeName("Deluxe");
//        duplicate.setMaxOccupancy(3);
//        duplicate.setPricePerNight(BigDecimal.valueOf(3000));
//
//        assertThatThrownBy(() -> repository.saveAndFlush(duplicate))
//                .isInstanceOf(Exception.class);
//    }
}