package electro.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import electro.store.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{

}
