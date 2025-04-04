## 기본 URL
```http
 localhost:8080/
```

## 1. Health Check API
서버 동작 여부를 확인하기 위한 API
- **Endpoint**: `/health`
- **Method**: `GET`
- **Request**: 없음
- **Response**:
    - **Type**: `String`
    - **Example**: `"1"`

### ✅ 예시
```http
GET /health
```

## 2. Open API 연동 - Cylinder 정보 조회

외부 API를 호출하여 `name`과 `editorAsset` 값을 추출하여 반환하는 API
- **Endpoint**: `/cylinder`
- **Method**: `GET`
- **Request**: 없음
- **Response**
    - **Type**: `JSON`
    - **Fields**:
        - `name`: String
        - `editorAsset`: Json

###  외부 API 정보

- **Endpoint**: `https://api.archisketch.com/v1/public/product/YB0Njg-02923BC5C1A84C59`
- **Method**: `GET`

### ✅ 예시

```http
GET /cylinder
```

## 3. 시군구 정보 조회

Test용 DB에 저장된 시군구 정보를 `pid_loc_code`를 기준으로 조회하는 API

- **Endpoint**: `/sigungu`
- **Method**: `GET`
- **Request Parameters**
  - `pid_loc_code` (쿼리 파라미터): 예) `1111000000`
- **Response**
  - **Type**: `JSON Array`
  - **Content**: 조회된 시군구 데이터

### ✅ 예시

```http
GET /sigungu?pid_loc_code=1111000000
```

## 4. 사용자 데이터 생성 API

사용자 정보를 테스트용 DB에 저장하는 API

- **Endpoint**: `/user`
- **Method**: `POST`
- **Request Body**
    - **Type**: `JSON`
    - **Fields**:
        - `name` (`String`) – 사용자 이름
        - `password` (`String`) – 사용자 비밀번호

#### Example Request

```json
{
  "name": "test",
  "password": "test1234"
}
```

## 5. 데이터 구조화 및 API 개발

- 아파트 단지
- 도로명 주소, 지번 주소
- 전용 면적 (오름차순, 내림차순)
- 기본형, 확장형
- 평형대 필터  (즉, 롯데캐슬리버파크시그니처 기준 112 로 검색하면 112B 와 112C 가 나올 수 있어야 함)
---
### 조건
- 아파트 단지는 여러 개의 평형(면적)을 가집니다.  
  예: **롯데캐슬리버파크시그니처** → `112B`, `112C`

- 면적은 두 가지로 구성되며, 소수점 둘째 자리까지 m² 단위로 표현됩니다.
    1. 전용 면적
    2. 공급 면적

- 크기는 같지만 평면도 형태나 타입이 다른 경우 존재합니다.  
  예: `112B`, `112C` (공급 면적을 정수로 내림한 후 사용)

- 동일 타입(예: `112B`)이라도 발코니 확장 여부에 따라
    - `112B 기본형`
    - `112B 확장형` 으로 구분됩니다.

- 한 아파트 단지는 여러 지번 주소 또는 도로명 주소를 가질 수 있습니다.
    - 예: [래미안힐스테이트고덕](https://realty.daum.net/home/apt/danjis/36216)은 `고덕동 688`, `690`, `691`에 걸쳐 있음

- 도면은 이미지로 관리되며, 형태가 다르면 고유한 도면으로 간주합니다.
---
- Endpoint: /floorplan
- Method: GET
- Query Parameters

  | 파라미터         | 타입                                 | 필수 여부 | 설명 |
  |------------------|------------------------------------|-----------|------|
  | `apartmentName`  | `String`                           | ❌        | 아파트 단지명 (정확히 일치) |
  | `address`        | `String`                           | ❌        | 도로명 또는 지번 주소 (정확히 일치) |
  | `addressType`    | `AddressType` (`ROAD` or `STREET`) | ❌ | 주소 타입 (도로명 / 지번) |
  | `unitPrefix`     | `String`                           | ❌        | 평형대 접두어 (예: `112`) |
  | `isExpanded`     | `Boolean`                          | ❌        | 확장형 여부 (`true` / `false`) |
  | `sortType`       | `SortType` (`ASC`, `DESC`)         | ❌ | 전용 면적 정렬 순서 |


### 데이터 삽입 단지 목록

| 단지명                         | 도로명 주소                                               | 지번 주소                              |
|--------------------------------|------------------------------------------------------------|-----------------------------------------|
| **고덕아르테온**               | 서울특별시 강동구 고덕로 360, 고덕로 380, 고덕로 390     | 서울특별시 강동구 상일동 519, 상일동 520 |
| **삼익맨션**                   | 서울특별시 강동구 상암로 224, 상암로 225                 | 서울특별시 강동구 명일동 270, 명일동 260-1 |
| **롯데캐슬리버파크시그니처**   | 서울특별시 광진구 뚝섬로 467                              | 서울특별시 광진구 자양동 236             |

## 실행방법

1. .env.example에 따라 .env값 작성 (mysql 접근)
2. Gradle 빌드
```
./gradlew build
```
3. 서버 실행
```
./gradlew bootRun
```

4. 실행 확인
```
curl http://localhost:8080/health
```