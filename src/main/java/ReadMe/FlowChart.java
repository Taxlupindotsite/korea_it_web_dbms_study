package ReadMe;

public enum FlowChart {


 /*
   작동 흐름은 이럼
    Controller -> Service -> repository -> mapper -> mapper.xml

   요청이 들어오면
   Controller로 처음 옴.
   (그럼 dto 또는 userid[requestParam])

   그리고 Service로
   (dto->entity로 바뀌어서 전송)

   그리고 Repository로
   (entity)

   그리고 mapper로
   (entity)

   그리고 mappers/mapper.xml로
   그리고 SQL이 실행됨

    Entity, Dto가 왔다갔다 하는거임
   DTO의 정의가 Data Transfer Object임
   데이터가 오고가고 할 때 쓰는 객체

---------------------------------------------------------------------------
   근데 짤때는 거꾸로 짜는게 좋음 그래야 빨간줄이 잘 안뜸

   1. dto부터 만들고
   2. entity됫을때 어떻게할지 쿼리(xml)에 씀
   3. 매퍼 만들고
   4. 레포지토리 만들고
   5. 서비스 만들고
   6. 컨트롤러 만들고












 */


}
