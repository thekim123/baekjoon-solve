---
## 1. 출근시 서버 재시작

1) 크롬 켜고 즐겨찾기에 Jenkins클릭
   - 대부분 열려있습니다.
2) 녹색 재생버튼 클릭
    - 메인 화면에 목록이 3개가 있는데 재생버튼이 보통 두번째에 있습니다.
    - 이외에 재생버튼이 생기면 대표님께 문의 하세요!!
3) XShell 실행
4) cd /home/apiwas_public/apache tomacat/bin
   - 중간 중간에 tab키를 누르시면 이름들이 자동 완성이 됩니다.
5) ./shutdown.sh
   - ./ -> 현재 폴더 내
6) ./startup_dev.sh
7) cd ../logs
   -  .. -> 폴더 한칸 위 경로
8) tail -f catalina.out
   - 서버에 입력되는 로그를 실시간으로 찍는 명령어
    
---
## 2. 컴퓨터 재부팅 시
1) nginx 실행
2) ngrok 포트 열기
   - 바탕화면에 있는 메모장에 적혀있는 80, 8000, 8080포트 여는 명령어를 입력하시면 됩니다. 
3) XShell 실행
4) sudo su
   - 비번 : @zxcv()01@#
   - 출근시에 안하는 이유는 이미 되어 있기 때문입니다. 



### 이후에는 출근시 서버 재시작과 동일합니다.

---