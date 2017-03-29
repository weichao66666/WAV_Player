# CMake版本信息
cmake_minimum_required(VERSION 3.4.1)

# 工程路径
set(pathToProject D:/android_studio_workspace/WAV_Player)
# Native 路径
set(pathToNative ${pathToProject}/transcode-1.1.7)

# 配置加载native依赖
include_directories(${pathToNative})
# 添加待编译的文件
add_library(WAV_Player SHARED ${pathToNative}/avilib/wavlib.c
                              ${pathToNative}/avilib/platform_posix.c
                              ${pathToProject}/app/src/main/cpp/io_weichao_wav_1player_MainActivity.h
                              ${pathToProject}/app/src/main/cpp/WAV_Player.cpp)

target_link_libraries(WAV_Player
                      OpenSLES)