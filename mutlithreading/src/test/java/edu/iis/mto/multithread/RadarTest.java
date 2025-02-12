package edu.iis.mto.multithread;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutorService;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @Mock
    private ExecutorService executorService;

    @RepeatedTest(10)
    void launchPatriotOnceWhenNoticesAScudMissle() {

        when(executorService.submit(any(Runnable.class))).thenAnswer(invocationOnMock -> {
            ((Runnable) invocationOnMock.getArgument(0)).run();
            return null;
        });

        BetterRadar radar = new BetterRadar(1,batteryMock,executorService);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);

        verify(batteryMock,times(1)).launchPatriot(enemyMissle);

    }

    @RepeatedTest(5)
    void launchThreePatriotOnceWhenNoticesAScudMissle()
    {
        when(executorService.submit(any(Runnable.class))).thenAnswer(invocationOnMock -> {
            ((Runnable) invocationOnMock.getArgument(0)).run();
            return null;
        });

        BetterRadar radar = new BetterRadar(3,batteryMock,executorService);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);

        verify(batteryMock,times(3)).launchPatriot(enemyMissle);

    }

    @RepeatedTest(15)
    void launchZeroPatriotOnceWhenNoticesAScudMissle()
    {
        when(executorService.submit(any(Runnable.class))).thenAnswer(invocationOnMock -> {
            ((Runnable) invocationOnMock.getArgument(0)).run();
            return null;
        });

        BetterRadar radar = new BetterRadar(0,batteryMock,executorService);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);

        verify(batteryMock,times(0)).launchPatriot(enemyMissle);

    }

}
