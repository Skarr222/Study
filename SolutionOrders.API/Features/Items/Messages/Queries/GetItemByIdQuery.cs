using MediatR;
using SolutionOrders.API.Features.Items.Messages.DTOs;

namespace SolutionOrders.API.Features.Items.Queries.GetAllItems
{
    // Query = Request który zwraca List<ItemDto>
    public class GetItemByIdQuery : IRequest<ItemDto>
    {
        public int Id { get; set; }
    }

    // DTO (Data Transfer Object) - model dla API
}
