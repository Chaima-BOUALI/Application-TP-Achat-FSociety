package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

	@Mock
	StockRepository sr;
	
	@InjectMocks
	StockServiceImpl ss;

	@Test
	public void testAddStock() {
		Stock stock = new Stock();

		Mockito.when(sr.save(ArgumentMatchers.any(Stock.class))).thenReturn(stock);

		Stock Stockadd = ss.addStock(stock);

		assertThat(Stockadd.getLibelleStock()).isSameAs(Stockadd.getLibelleStock());
	}

	@Test
	public void RetrieveAllStockTest() {
		List<Stock> stocks = new ArrayList<>();
		stocks.add(new Stock());

		when(sr.findAll()).thenReturn(stocks);

		List<Stock> expected = ss.retrieveAllStocks();
		
		assertEquals(expected, stocks);
		verify(sr).findAll();
	}
	
}
