package de.seuhd.campuscoffee.domain.implementation;

import de.seuhd.campuscoffee.domain.model.objects.Review;
import de.seuhd.campuscoffee.domain.ports.data.CrudDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CrudServiceTest{
    @Mock
    private CrudDataService<Review, Long> crudDataService;

    private CrudServiceImpl<Review, Long> crudService;

    @BeforeEach
    void setUp() {
        crudService = new CrudServiceImpl<>(Review.class) {
            @Override
            protected CrudDataService<Review, Long> dataService() {
                return crudDataService;
            }
        };
    }

    @Test
    void clear_delegatesToDataService() {
        // when
        crudService.clear();

        // then
        verify(crudDataService).clear();
    }

}
