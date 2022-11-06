package com.esprit.examen.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.OperateurServiceImpl;
import com.esprit.examen.services.ProduitServiceImpl;
import com.esprit.examen.services.StockServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class OperateurServiceImplMockTest {

	 	@Mock
	    OperateurRepository operateurRepository;

	    @InjectMocks
	    OperateurServiceImpl operateurService;

	    Operateur o1 = new Operateur(12L, "cyrine","Ch","23333",null);
	    Operateur o2 = new Operateur(22L, "cyrine2","Ch2","000000",null);

	    List<Operateur> listOperateurs = new ArrayList<Operateur>() {
	        {
	            add(o1);
	            add(new Operateur(10L, "N1","P1","11",null));
	            add(new Operateur(20L, "N2","P2","22",null));
	        }
	    };

	    @Test
	    public void retrieveOperateur() {
	        System.out.println("retrieveOperateurs");
	        Mockito.when(operateurRepository.findById(12L)).thenReturn(Optional.of(o1));
	        Operateur operateur1 = operateurService.retrieveOperateur(12L);
	        assertNotNull(operateur1);
	    }
	    @Test
	   public void testretrieveAllOperateurs() {
	        System.out.println("retrieveAllOperateurs");
	        Mockito.when(operateurRepository.findAll()).thenReturn(listOperateurs);
	        List<Operateur> operateurList3 = operateurService.retrieveAllOperateurs();
	        assertEquals(3, operateurList3.size());
	        //assertEquals(operateur1.,55L);
	    }

	    @Test
	   public void testaddOperateur(){
	        System.out.println("testaddOperateur");
	        Mockito.when(operateurRepository.save(o1)).thenReturn(o1);
	        Operateur operateur1 = operateurService.addOperateur(o1);
	        assertNotNull(operateur1);
	        Mockito.verify(operateurRepository, times(1)).save(Mockito.any(Operateur.class));
	    }

	    
	    

	    @Test
	   public void testdeleteOperateur(){
	        System.out.println("testdeleteoperateur");
	        operateurService.deleteOperateur(66L);
	        Mockito.verify(operateurRepository, times(0)).delete(o2);
	    }
	
}
