@echo off

:: Function to kill process by port number
setlocal
set "PORTS=1099 1100 1101"

for %%P in (%PORTS%) do (
    echo Checking port %%P...
    for /f "tokens=5" %%A in ('netstat -ano ^| findstr :%%P') do (
        echo Killing process with PID %%A using port %%P...
        taskkill /PID %%A /F
    )
)

endlocal
echo Done.

rem pause the following line if you want to see the output
pause
