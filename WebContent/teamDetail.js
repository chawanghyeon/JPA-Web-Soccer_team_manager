// 선수 상세보기 비동기 처리하는 함수 - 윤혜
function step02() {
        axios
          .get('response.jsp', {
            params: {
              name: '유재석',
              age: 40,
            },
          })
          .then((resData) => {
            console.log(resData.data.name);
          })
          .catch((error) => {
        	  console.log(error);
          });
      }

// 감독 상세보기 비동기 처리하는 함수 - 혜성


// 의료진 상세보기 비동기 처리하는 함수 - 왕현


// 트레이너 상세보기 비동기 처리하는 함수 - 왕현


